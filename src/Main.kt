// Jared Wightman Hangman project (Kotlin)

import java.io.File

// "Word" class that stores the word, its type, and decides if it will be plural or not if it's a noun
data class Word(var word: String, val type: String) {
    val plurality = (0..1).random()

    init {
        if ((type == "Noun") and (plurality == 1)) {
            word += "s"
        }
    }
}

var phrase = ""

// Function for setup of structured phrase of random words
fun selectWords() {

    val adjArray = mutableListOf<Word>()
    val nounArray = mutableListOf<Word>()
    val verbArray = mutableListOf<Word>()

    // Going line-by-line and turning each word into an instance of the Word class, then adding to an array for that type
    File("Words.txt").forEachLine {
        val segmentedLine = it.split(", ")
        val word = Word(segmentedLine[0],segmentedLine[1])
        //if (word.type == "Adjective") adjArray += word
        when (word.type) {
            "Adjective" -> adjArray += word
            "Noun" -> nounArray += word
            "Verb" -> verbArray += word
        }
    }

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

        // Comparing letter input to letters in phrase, editing result to show correct letters
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
            // Tracking and showing strikes
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

