package org.kivio.sample.service;

import javax.enterprise.context.Dependent;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Dependent
@ApplicationPath("sample")
public class SampleApplication extends Application {
}
