# Overview

This project is an in-terminal hangman game where you guess the letters in a phrase. The phrase is constructed with a very simple pattern (Adjective, Noun, Verb, Adjective, Noun) using random words that can be plural or singular. These words are read from a pre-formatted text file.

I wrote this software in order to learn the basics of the Kotlin Language, as well as becoming more familiar with a new IDE IntelliJ and how projects interlink with GitHub.

[Software Demo Video](https://youtu.be/ZC_QEsCSQho)

# Development Environment

This project was made in Kotlin using the IntelliJ IDEA. Kotlin doesn't have a file accessing-and-reading system, so the File library from Java was used.

# Useful Websites

- [kotlinlang.org (classes)](https://kotlinlang.org/docs/data-classes.html#properties-declared-in-the-class-body)
- [kotlinlang.org (random)](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.random/-random/)
- [kotlinlang.org ("when" statement)](https://kotlinlang.org/docs/control-flow.html#when-expression)
- [baeldung.com (arrays)](https://www.baeldung.com/kotlin/check-if-array-contains-value)
- [baeldung.com (file reading)](https://www.baeldung.com/kotlin/read-file)
- [baeldung.com (split)](https://www.baeldung.com/kotlin/split-string)
- [developer.android.com (variables)](https://developer.android.com/kotlin/learn#:~:text=Kotlin%20uses%20two%20different%20keywords,variable%20whose%20value%20can%20change)
- [tutorialspoint.com (strings)](https://www.tutorialspoint.com/how-to-correctly-concatenate-strings-in-kotlin#:~:text=There%20are%20different%20ways%20to,operator%20to%20join%20two%20strings)
- [techiedelight.com (alphabet)](https://www.techiedelight.com/check-if-string-contains-only-alphabets-kotlin/)

# Future Work

- Configure file-reading system to only read lines formatted a certain way (to avoid errors)
- Add more types of words and sentence structures
- Keep track of errors
- Add an actual "Hangman" graphic that progresses with mistakes
- Simplify the relationship between the actual phrase, the phrase as hidden, and the phrase as progress is made in guessing (changes type several times)

