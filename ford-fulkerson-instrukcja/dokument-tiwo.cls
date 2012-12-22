\NeedsTeXFormat{LaTeX2e}
\ProvidesClass{dokument-tiwo}[2012/12/17 Klasa dla dokumentów powstałych w ramach projektu TiWO 2012/2013]

\LoadClassWithOptions{article}

\RequirePackage{polski}
\RequirePackage{xltxtra}
\RequirePackage{xparse}

\RequirePackage{graphicx}

\RequirePackage{geometry}
\geometry{
  paper=a4paper,
  margin=2.54cm
}

\RequirePackage{setspace}
\onehalfspacing

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
  unicode=true
}

\RequirePackage{listings}
\RequirePackage{color}
\RequirePackage{textcomp}
\definecolor{listinggray}{gray}{0.9}
\definecolor{lbcolor}{rgb}{0.9,0.9,0.9}
\lstset{
    backgroundcolor=\color{lbcolor},
    tabsize=4,
    rulecolor=,
    language=Java,
    basicstyle=\scriptsize,
    upquote=true,
    aboveskip={1.5\baselineskip},
    columns=fixed,
    showstringspaces=false,
    extendedchars=true,
    breaklines=true,
    prebreak = \raisebox{0ex}[0ex][0ex]{\ensuremath{\hookleftarrow}},
    frame=single,
    showtabs=false,
    showspaces=false,
    showstringspaces=false,
    identifierstyle=\ttfamily,
    keywordstyle=\color[rgb]{0,0,1},
    commentstyle=\color[rgb]{0.133,0.545,0.133},
    stringstyle=\color[rgb]{0.627,0.126,0.941},
}

\RequirePackage{dokument-tiwo-meta}
\RequirePackage{dokument-tiwo-versions}

\defaultfontfeatures{Mapping=tex-text}
\setromanfont{Charis SIL}
\setmonofont[Scale=MatchLowercase]{Inconsolata}
\setsansfont[Scale=MatchLowercase]{Source Sans Pro}
\RenewDocumentCommand {\familydefault} { } {\sfdefault}
