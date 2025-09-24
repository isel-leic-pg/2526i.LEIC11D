fun main() {
	print("Letra? ")
	val letter = readln()[0]
	println("Código= ${letter.code}")
	val txt = when( letter ) {
	   in 'A'..'Z' -> "maiúscula"
	   in 'a'..'z' -> "minúscula"
	   in '0'..'9' -> "digíto"
	   'ç','Ç' -> "um c com cedilha"
	   else -> "um simbolo"
	}
	println("$letter é $txt")
	
	/*
	//println("Maiúscula= ${letter in 'A'..'Z'}")
	if (letter !in 'A'..'Z') {
	   println("$letter não é maiúscula")
	}
	println("Minúscula= ${letter in 'a'..'z'}")
	*/
	
}