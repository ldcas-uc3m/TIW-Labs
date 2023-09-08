#!/bin/bash
# Bash script to zip the whole project in order to make it deriverable
# please make sure zip, pv and texlive are installed

OUTFILE=../outfile.zip

# make sure git is up to date
echo "Making sure git is up to date..."
git pull
git checkout main

# compile the report (and save it to root folder)
echo "Compiling the report..."
cd report

pdflatex report.tex -halt-on-error > /dev/null
cp report.pdf ..

cd ..

# remove whatever is in src/.gitignore
echo "Removing files in .gitignore..."
cd src

for f in $(cat .gitignore) ; do 
    rm -rf "$f"
done

cd ..

# zip it (excluding useless stuff)
echo "Zipping..."
zip -r $OUTFILE . -x zip.sh report/\* \*.git\* README.md

# cleanup
echo "Cleaning up..."
git reset --hard HEAD
