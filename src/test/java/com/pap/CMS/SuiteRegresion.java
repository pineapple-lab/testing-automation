package com.pap.CMS;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Suite por tag: regresion")
@SelectPackages("com.pap.CMS")
@IncludeTags("regresion")
public class SuiteRegresion {
}
