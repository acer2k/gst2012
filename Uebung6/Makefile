TEMPORARIES=*aux *toc *log *blg *bbl *out *lol *lot *lof
ARTIFACTS=*dvi *ps
LATEX_OPTS=-interaction=nonstopmode

all: clean pdf

compile:
	latex $(LATEX_OPTS) Abgabe.tex
# bibtex8 report
# latex $(LATEX_OPTS) Abgabe.tex
# latex $(LATEX_OPTS) Abgabe.tex

pdf: removetemporaries
	pdflatex $(LATEX_OPTS) Abgabe.tex
	#dvips Abgabe.dvi
	#ps2pdf Abgabe.ps
	rm -f *dvi *ps

clean:
	rm -f $(TEMPORARIES) $(ARTIFACTS)
removetemporaries:
	rm -f $(TEMPORARIES)

