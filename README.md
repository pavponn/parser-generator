# Parser Generator
[![MIT license](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/pavponn/parser-generator/blob/master/LICENSE)
![Java CI with Maven](https://github.com/pavponn/parser-generator/workflows/Java%20CI%20with%20Maven/badge.svg)

## Summary
This program generates parser's sources from file with the LL(1) grammar for some language.
Project's goal is to gain more understanding of how parser generators (like ANLTR, Bison, Happy) work.

It accepts file with LL(1) written in the format that is quite close to the one used in ANLTR (`.g4` files). 

## Usage
Run `Main` providing location of the grammar file as an argument via console or you may simply place it into this source [file](https://github.com/pavponn/parser-generator/blob/master/src/main/java/Main.java).

Input grammar format is specified [here](https://github.com/pavponn/parser-generator/blob/master/src/main/java/ReaderParser.g4).

## Examples

|Example|Grammar File|Generated Sources |
|---|---|---|
|Calculator|[calculator grammar](https://github.com/pavponn/parser-generator/blob/master/src/main/resources/calculator)|[calculator sources](https://github.com/pavponn/parser-generator/tree/master/src/main/java/parser/calculator)   |
|Regular Expressions | [regex grammar](https://github.com/pavponn/parser-generator/blob/master/src/main/resources/regex)| [regex sources](https://github.com/pavponn/parser-generator/tree/master/src/main/java/parser/regex)  |
|Pascal   | [pascal grammar](https://github.com/pavponn/parser-generator/blob/master/src/main/resources/calculator)  |[pascal sources](https://github.com/pavponn/parser-generator/tree/master/src/main/java/parser/pascal)   |

## Test
Tested using JUnit 4.

## Copyright
Pavel Ponomarev, 2020 (pavponn@gmail.com)

MIT License
