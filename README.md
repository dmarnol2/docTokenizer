# About Java Document Tokenizer
This program scans a provided document for words found in a given lexicon.

If a word is found, it is appended with it's associated token.

A new document is written to file as a copy of the original, replacing the found word with it's tagged version while maintaining the original formatting in all other cases.

# To Run Program From Terminal

Download the zipfile or clone the program. To clone, in your terminal, navigate to the folder where you want the program downloaded and enter:

`git clone https://github.com/dmarnol2/docTokenizer.git`

# OR
if you have the zipfile, use this command in the directory where the zipfile is located. 

`unzip docTokenizer.zip`

After cloning or opening the zipfile, in your terminal enter these commands (Please note: please ensure the initial directory is correct. If you download the zip directly from Github, it is very likely the directory will be `docTokenizer-main` AND NOT `docTokenizer` as in the command below):

`cd docTokenizer/src/com/document/tokenizer` 

`javac Main.java`

`java Main.java`


In the terminal you will be prompted to enter the path of the document you would like scanned.

You will then be prompted to enter the path of the lexicon.

After file locations have been entered, the program will scan the document against the lexicon and append any found words with it's associated token.

Tagged words will have the format: `<word>/<token>`

The program will write the output to file. The file will be located in the same directory as the scanned document and will have the same name but with the `.tag` extension.
