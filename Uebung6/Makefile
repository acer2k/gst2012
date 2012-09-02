TEMPORARIES=*aux *toc *log *blg *bbl *out *lol *lot *lof
ARTIFACTS=*pdf *dvi *ps
LATEX_OPTS=-interaction=nonstopmode

all: clean pdf

compile:
	latex $(LATEX_OPTS) Abgabe.tex
# bibtex8 report
# latex $(LATEX_OPTS) Abgabe.tex
# latex $(LATEX_OPTS) Abgabe.tex

pdf: compile removetemporaries
	dvips Abgabe.dvi
	ps2pdf Abgabe.ps
	rm -f *dvi *ps

clean:
	rm -f $(TEMPORARIES) $(ARTIFACTS)
removetemporaries:
	rm -f $(TEMPORARIES)

