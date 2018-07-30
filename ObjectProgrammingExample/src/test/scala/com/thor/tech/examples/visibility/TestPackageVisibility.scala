package com.thor.tech.examples.visibility

class TestPackageVisibility {
  val f = new PackageProtected

  //************************* .doX cannot see inside [visibility] package******************
  //f.doX
}