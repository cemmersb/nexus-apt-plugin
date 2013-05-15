package com.github.sannies.nexusaptplugin.ar;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArReaderTest {

  private final static Logger LOGGER = LoggerFactory.getLogger(ArReaderTest.class);

  @Test
  public void test() throws IOException {
    File deb = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getFile(), "php5_5.3.10-1ubuntu3.2_all.deb");
    ArReader arReader = new ArReader(deb);
    for (ReadableArFile readableArFile : arReader) {
      LOGGER.error("Could not read file with name: {}", readableArFile.getName());
      readableArFile.open();
    }
  }
}