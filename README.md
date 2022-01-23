# Java Document Tokenizer
This program scans a provided document for words found in a given lexicon.

If a word is found, it is appended with the associated token.

A new document is written to file as a copy of the original, replacing the found word with it's tagged version and maintaining the original formattiing in all other cases.

# To Run Program From Terminal

In your terminal, navigate to folder where you want the program downloaded.

Enter the following commands:

`git clone https://github.com/dmarnol2/docTokenizer.git`

`cd docTokenizer/src/com/document/tokenizer`

`javac Main.java`

`java Main.java`


In the terminal you will be prompted to enter the path of the document you would like scanned.

You will then be prompted to enter the path of the lexicon.

After file locations have been entered, the program will scan the document against the lexicon and append any found words with it's associated token.

Tagged words will have the format: `<word>/<token>`

The program will write the output to file. The file will be located in the same directory as the scanned document and will have the same name but with the `.tag` extension.
