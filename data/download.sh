echo "Downloading pdb & rnastrand RNA secondary structure datasets"

wget http://iimcb.genesilico.pl/comparna/site_media/entire_datasets/pdb.zip
wget http://iimcb.genesilico.pl/comparna/site_media/entire_datasets/rnastrand.zip

unzip -d pdb pdb.zip
unzip -d rnastrand rnastrand.zip

rm *.zip
