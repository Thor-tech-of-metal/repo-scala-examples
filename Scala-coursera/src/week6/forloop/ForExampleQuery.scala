package week6.forloop

/**
  * Created by thor on 19/07/16.
  */
class ForExampleQuery {

  val books : List[Book]= List(
    new Book(pTitle="pepeGrillo", pAuthors=List("Tobias")),
    new Book(pTitle="porno", pAuthors=List("alexis texas","Michelle barrent")),
    new Book(pTitle="pepe", pAuthors=List("tobias","alexis texas"))
  )

  def getBooksStartWith(startWith:String): List[String]={

    for( b<-books if b.title.indexOf(startWith ) >= 0 )
    yield b.title
  }

  def getBooksWithAuthorsStartWith(startWith:String): List[String]={

    (
      for( b<-books; a <- b.authors if a.indexOf(startWith ) >= 0)
      yield b.title
    ).distinct

  }

}

class Book(pTitle:String,pAuthors:List[String]){

  val title=pTitle
  val authors=pAuthors
}

object test{

  def main(args: Array[String]) {
    val forExampleQuery= new ForExampleQuery
    val titleStartWith = forExampleQuery.getBooksStartWith("p")
    val booksWithAuthorsStartWith = forExampleQuery.getBooksWithAuthorsStartWith("t")

    println(titleStartWith)
    println(booksWithAuthorsStartWith)
  }
}