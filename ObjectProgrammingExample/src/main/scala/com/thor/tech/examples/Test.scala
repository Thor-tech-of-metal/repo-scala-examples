package com.thor.tech.examples

import com.thor.tech.examples.visibility.PackageProtected

class Test {
  val f = new PackageProtected

  //************************* .doX cannot see inside [visibility] package******************
  //f.doX
}