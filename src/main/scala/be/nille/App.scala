/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.nille
import java.io.File
import scala.io.Source

object App {

  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    println("Starting program")
   
    getListOfFiles(getClass.getClassLoader.getResource("files").getPath)
    .foreach(file => {
        println(file.getName + "\n");
        Source.fromFile(file).getLines.map(User(_)).toList.foreach(user => println("User:" + user))
        println("\n")
     })
   
    
    println("Ending program")
    
  }

  def getListOfFiles(dir: String): List[File] = {
    val d = new File(dir)
    if (d.exists && d.isDirectory) {
      d.listFiles.filter(_.isFile).toList
    } else {
      List[File]()
    }
  }

}
