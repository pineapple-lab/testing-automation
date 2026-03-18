package InsumosSpacelogik;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.*;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;

import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class GoogleSheetsService {
    private Sheets service;

    public GoogleSheetsService(String credentialsPath) throws Exception {
        GoogleCredentials credentials = ServiceAccountCredentials.fromStream(new FileInputStream(credentialsPath))
                .createScoped(Collections.singleton(SheetsScopes.SPREADSHEETS));

        this.service = new Sheets.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                GsonFactory.getDefaultInstance(),
                new HttpCredentialsAdapter(credentials))
                .setApplicationName("BotSpacelogik")
                .build();
    }
    public void prepareExecutionColumn(String spreadsheetId) throws Exception {
        Spreadsheet spreadsheet = service.spreadsheets().get(spreadsheetId).execute();
        int firstSheetId = spreadsheet.getSheets().get(0).getProperties().getSheetId();
        Request request = new Request().setInsertDimension(new InsertDimensionRequest()
                .setRange(new DimensionRange()
                        .setSheetId(firstSheetId)
                        .setDimension("COLUMNS")
                        .setStartIndex(0)
                        .setEndIndex(1)));
        BatchUpdateSpreadsheetRequest batchUpdate = new BatchUpdateSpreadsheetRequest().setRequests(Collections.singletonList(request));
        service.spreadsheets().batchUpdate(spreadsheetId, batchUpdate).execute();
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        ValueRange body = new ValueRange().setValues(Collections.singletonList(Collections.singletonList(date)));
        service.spreadsheets().values().update(spreadsheetId, "A1", body).setValueInputOption("RAW").execute();
    }

    public void updateRowStatus(String spreadsheetId, int rowIndex, String status) throws Exception {
        String range = "A" + rowIndex;
        ValueRange body = new ValueRange().setValues(Collections.singletonList(Collections.singletonList(status)));
        service.spreadsheets().values().update(spreadsheetId, range, body).setValueInputOption("RAW").execute();
    }
    public void startReporting(String spreadsheetId) {
        try {
            this.prepareExecutionColumn(spreadsheetId);
            System.out.println("Columna de reporte creada en Google Sheets.");
        } catch (Exception e) {
            System.err.println("No se pudo preparar la columna en Drive: " + e.getMessage());
        }
    }
    public void reportResult(String spreadsheetId, int caseIndex, String status) {
        try {
            this.updateRowStatus(spreadsheetId, caseIndex + 1, status);
        } catch (Exception e) {
            System.err.println("Error al reportar en Google Sheets: " + e.getMessage());
        }
    }
}
