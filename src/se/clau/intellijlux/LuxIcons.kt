package se.clau.intellijlux

import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

object LuxIcons {
  val FILE = load("/se/clau/intellijlux/icons/light-bulb.png")

  val FILE_INC = load("/se/clau/intellijlux/icons/light-bulb-inc.png")

  private fun load(path: String): Icon =
    IconLoader.getIcon(path, LuxIcons::class.java)
}