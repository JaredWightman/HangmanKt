
// TO DO
// documentation and comments
// figure out creating and reading a text file (spreadsheet?)
// Hours: 1 (plan/init), 3 (basic structure and game + researching, 1 (wresting GitHub), 1 (polishing markdown and comments),
//

// "Word" class that stores the word, its type, and decides if it will be plural or not if it's a noun
data class Word(var word: String, val type: String) {
    val plurality = (0..1).random()

    init {
        if ((type == "Noun") and (plurality == 1)) {
            word += "s"
        }
    }
}

// These words are a temporary placeholder, to get the phrase working.
val word1 = Word("bean", "Noun")
val word2 = Word("blue", "Adjective")
val word3 = Word("bake", "Verb")
val word4 = Word("bat", "Noun")
val word5 = Word("blubbery", "Adjective")


//////////////////////////////////////
var initArray = arrayOf(word1, word2, word3, word4, word5)
var phrase = ""

// Function for setup of structured phrase of random words
fun selectWords() {

    //File(Words.txt)





    // Sorting adjectives into their own array
    val adjArray = mutableListOf<Word>()
    for (i in initArray) if (i.type == "Adjective") adjArray += i
    // Sorting nouns into their own array
    val nounArray = mutableListOf<Word>()
    for (i in initArray) if (i.type == "Noun") nounArray += i
    // Sorting verbs into their own array
    val verbArray = mutableListOf<Word>()
    for (i in initArray) if (i.type == "Verb") verbArray += i

    // Adding first adjective
    val randomAdj1 = adjArray.random()
    adjArray.remove(randomAdj1)
    phrase += randomAdj1.word + " "

    // Adding first noun
    val randomNoun1 = nounArray.random()
    nounArray.remove(randomNoun1)
    phrase += randomNoun1.word + " "

    // Adding verb and setting it to follow plurality of the first noun
    val randomVerb = verbArray.random()
    verbArray.remove(randomVerb)
    if (randomNoun1.plurality == 0) {
        randomVerb.word += "s"
    }
    phrase += randomVerb.word + " "

    // Adding second adjective
    val randomAdj2 = adjArray.random()
    adjArray.remove(randomAdj2)
    phrase += randomAdj2.word + " "

    // Adding second noun
    val randomNoun2 = nounArray.random()
    nounArray.remove(randomNoun2)
    phrase += randomNoun2.word + " "

}


fun main() {
    
    // Setup of in-terminal prompts and phrase
    var input = ""
    var strikes = 0
    selectWords()
    println(phrase) // remove this////////////////////////////////////////////////////////////////////////////////////
    println("Hangman! Guess the phrase in the lowest number of letters. \nEach incorrect guess will give a strike. Enter lowercase letters only. \n(Press 1 to exit)\n")
    
    // Taking the actual phrase and converting it into a hidden phrase to be printed
    var hiddenPhrase = ""
    for (char in phrase) {
        hiddenPhrase += if (char != ' ') {
            '_'
        } else {
            ' '
        }
    }
    // Sending underscorified phrase to a list so correctly guessed letters can be added
    val resultPhrase = hiddenPhrase.toMutableList()

    // Loop for guessing part of hangman
    while (input != "1")
    {
        // Printing all items stored in mutable list for result
        resultPhrase.forEach {
            print(it)
        }

        println()
        input = readLine().toString()

        // Comparing letter input to letters in phrase, editing result to show correct letters and strikes
        if ((input in "a".."z") and (input in phrase) and (input != " "))
        {
            var iterator = 0
            for (char in phrase) {
                if (char.toString() == input) {
                    resultPhrase[iterator] = char
                }
                iterator += 1
            }
        } else {
            strikes += 1
            println("Strike! ($strikes)")
        }

        // Checking if there are unguessed letters, ending game
        if (!resultPhrase.contains('_')) {
            println(phrase)
            println("You finished with $strikes strikes!")
            input = "1"
        }
    }
}

