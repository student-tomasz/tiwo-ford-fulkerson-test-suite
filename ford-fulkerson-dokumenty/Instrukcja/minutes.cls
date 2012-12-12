\NeedsTeXFormat{LaTeX2e}
\ProvidesClass{minutes}[2012/12/03 Klasa dla notatek ze spotkań w ramach projektu PPI 2012/2013]

\LoadClassWithOptions{article}

\RequirePackage{polski}
\RequirePackage{xltxtra}
\RequirePackage{xparse}

\RequirePackage{geometry}
\geometry{
  paper=a4paper,
  margin=2.54cm
}

\RequirePackage{lastpage}

\RequirePackage{fancyhdr}
\fancypagestyle{plain}{%
    \fancyhf{}
    \fancyfoot[C]{Strona \thepage{} z \pageref{LastPage}}
    \renewcommand{\headrulewidth}{0pt}
    \renewcommand{\footrulewidth}{0pt}
}
\pagestyle{plain}

\RequirePackage{hyperref}
\hypersetup{
  unicode=true,
  hyperfootnotes=false
}

\RequirePackage[normalem]{ulem}

\RequirePackage[symbol,marginal]{footmisc}

\RequirePackage{minutes-meta}
\RequirePackage{minutes-lista}

\defaultfontfeatures{Mapping=tex-text}
\setromanfont{Charis SIL}
\setmonofont[Scale=MatchLowercase]{Inconsolata}
\setsansfont[Scale=MatchLowercase]{Source Sans Pro}
\RenewDocumentCommand {\familydefault} { } {\sfdefault}
