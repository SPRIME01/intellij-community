/*
 * Copyright 2000-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.execution.junit;

import com.intellij.openapi.projectRoots.ex.JavaSdkUtil;
import com.intellij.openapi.roots.ExternalLibraryDescriptor;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

/**
 * @author nik
 */
public abstract class JUnitExternalLibraryDescriptor extends ExternalLibraryDescriptor {
  public static final ExternalLibraryDescriptor JUNIT3 = new JUnitExternalLibraryDescriptor("3") {
    @NotNull
    @Override
    public List<String> getLibraryClassesRoots() {
      return Collections.singletonList(JavaSdkUtil.getJunit3JarPath());
    }
  };
  public static final ExternalLibraryDescriptor JUNIT4 = new JUnitExternalLibraryDescriptor("4") {
    @NotNull
    @Override
    public List<String> getLibraryClassesRoots() {
      return JavaSdkUtil.getJUnit4JarPaths();
    }
  };
  private final String myVersion;

  public JUnitExternalLibraryDescriptor(String version) {
    super("junit", "junit", version + ".0", version + ".999");
    myVersion = version;
  }

  @Override
  public String getPresentableName() {
    return "JUnit" + myVersion;
  }
}
