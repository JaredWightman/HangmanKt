// First Kotlin project, using this to learn the syntax.



// TODO
// documentation and comments
// integrate with GIT (new project, MD)
// figure out creating and reading a text file (spreadsheet?)
// Hours: 1 (plan/init), 3 (basic structure and game + researching)


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

// Sentence structure: Adjective Noun Verb Adjective Noun
// One or more of the nouns and verbs will randomly be plural
var initArray = arrayOf(word1, word2, word3, word4, word5)
var phrase = ""

fun selectWords() {

    // Loading up adjectives to pick from
    var adjArray = mutableListOf<Word>()
    for (i in initArray) if (i.type == "Adjective") adjArray += i
    // Loading up nouns to pick from
    var nounArray = mutableListOf<Word>()
    for (i in initArray) if (i.type == "Noun") nounArray += i
    // Loading up verbs to pick from
    var verbArray = mutableListOf<Word>()
    for (i in initArray) if (i.type == "Verb") verbArray += i

    // Adding first adjective
    val randomAdj1 = adjArray.random()
    adjArray.remove(randomAdj1)
    phrase += randomAdj1.word + " "

    // Adding first noun
    val randomNoun1 = nounArray.random()
    nounArray.remove(randomNoun1)
    phrase += randomNoun1.word + " "

    // Adding verb
    var randomVerb = verbArray.random()
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

    println(initArray)
    selectWords()
    println(phrase)
    println("Hangman! Guess the phrase in the lowest number of letters. \nEach incorrect guess will give a strike. Enter lowercase letters only. \n(Press 1 to exit)\n")

    var input = ""
    var strikes = 0
    var shownPhrase = ""
    for (char in phrase) {
        if (char != ' ') {
            shownPhrase += '_'
        } else {
            shownPhrase += ' '
        }
    }
    var ownPhrase = shownPhrase.toMutableList()

    while (input != "1")
    {
        ownPhrase.forEach {
            print(it)
        }
        println()
        input = readLine().toString()
        if ((input in "a".."z") and (input in phrase) and (input != " "))
        {
            var iterator = 0
            for (char in phrase) {
                if (char.toString() == input) {
                    ownPhrase[iterator] = char
                }
                iterator += 1
            }
        } else {
            strikes += 1
            println("Strike! ($strikes)")
        }
        if ((ownPhrase.contains('_')) == false) {
            println(phrase)
            println("You finished with $strikes strikes!")
            input = "1"
        }
    }
}

