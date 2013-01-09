\NeedsTeXFormat{LaTeX2e}
\ProvidesClass{dokument-tiwo}[2012/12/25 Klasa dla dokumentów powstałych w ramach projektu TiWO 2012/2013]

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
\RequirePackage{xcolor}
\RequirePackage{textcomp}
\definecolor{dkgreen}{rgb}{0.2,0.6,0.2}
\definecolor{gray}{rgb}{0.5,0.5,0.5}
\definecolor{mauve}{rgb}{0.58,0,0.82}
\lstset{
    aboveskip=0.67\baselineskip,
    belowskip=1.0\baselineskip,
    basicstyle=\ttfamily\footnotesize,
    numbers=none,
    numberstyle=\tiny\color{gray},
    %firstnumber=1,
    %stepnumber=5,
    %numbersep=5pt,
    language=Java,
    tabsize=4,
    breaklines=true,
    breakatwhitespace=false,
    prebreak = \raisebox{0ex}[0ex][0ex]{\ensuremath{\hookleftarrow}},
    showspaces=false,
    showstringspaces=false,
    showtabs=false,
    frame=tb,
    captionpos=b,
    numberstyle=\tiny\color{gray},
    keywordstyle=\color{mauve},
    commentstyle=\color{dkgreen},
    stringstyle=\color{mauve}
}

\RequirePackage[inline]{enumitem}
\setlist{nosep}

\RequirePackage{titlesec}
\titleformat{\paragraph}[hang]{\normalfont\normalsize\bfseries}{\theparagraph}{1em}{}
\titlespacing*{\paragraph}{0pt}{3.25ex plus 1ex minus .2ex}{0pt}

\RequirePackage{dokument-tiwo-meta}
\RequirePackage{dokument-tiwo-versions}

\defaultfontfeatures{Mapping=tex-text}
\setromanfont{Charis SIL}
\setmonofont[Scale=MatchLowercase]{Inconsolata}
\setsansfont[Scale=MatchLowercase]{Source Sans Pro}
\RenewDocumentCommand {\familydefault} { } {\sfdefault}
