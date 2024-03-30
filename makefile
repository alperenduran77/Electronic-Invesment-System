# Compiler settings
JCC = javac
JFLAGS = -g

# Javadoc settings
DOC = javadoc
DOCFLAGS = -d doc -author -version

# Source files
SRCS = $(wildcard *.java)

# Class files
CLSS = $(SRCS:.java=.class)

# JAR settings
JAR = Main.jar
MAIN = Main

# Default action: clean, compile, docs, and run
all: clean compile docs jar run

# Compile the Java files into class files
compile: $(CLSS)

%.class: %.java
	@$(JCC) $(JFLAGS) $<

# Generate Javadoc
docs:
	@$(DOC) $(DOCFLAGS) $(SRCS) > /dev/null 2>&1

# Create a jar file
jar: $(CLSS)
	@jar cfe $(JAR) $(MAIN) $(CLSS)

# Run the program
run:
	@java $(MAIN)

# Clean the class files, jar, and any .txt files
clean:
	@rm -f *.class $(JAR) *.txt

# Clean all (class files, jar, and docs)
clean-all: clean
	@rm -rf doc

# Phony targets
.PHONY: all compile docs jar run clean clean-all
