JAVAC=/usr/bin/javac
.SUFFIXES: .java .class
SRCDIR=src
BINDIR=bin

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES=Country.class VaccineArray.class VaccineArrayApp.class BinaryTreeNode.class BTQueueNode.class BTQueue.class BinaryTree.class BinarySearchTree.class VaccineBSTApp.class
CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)
clean:
	rm $(BINDIR)/*.class

runVaccineArrayApp: $(CLASS_FILES)
	java -cp $(BINDIR) VaccineArrayApp

runVaccineBSTApp: $(CLASS_FILES)
	java -cp $(BINDIR) VaccineBSTApp

