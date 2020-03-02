#!/bin/bash
#
# Miguel Oliveira e Silva (mos@ua.pt), 2020

echo "=== Removing antlr4 installation. ==="
echo -n "Are you sure (y/N)? "; read ans
if [[ $ans == "y" || $ans == "Y" ]]; then
   JAR_DST_PATH=/usr/local/lib
   BIN_DST_PATH=/usr/local/bin
   DOC_DST_PATH=/usr/local/doc/javadoc
   sudo rm -vf "$JAR_DST_PATH"/antlr-*.jar "$JAR_DST_PATH"/ST-*.jar
   sed -i 's/^\<export\> \<CLASSPATH\>.*$//g' ~/.bashrc
   sed -i 's/^\<export\> \<ANTLR4_PATH\>.*$//g' ~/.bashrc
   sudo rm -vf "$BIN_DST_PATH"/antlr4* "$BIN_DST_PATH"/java-clean "$BIN_DST_PATH"/view-javadoc
   sudo rm -vrf "$DOC_DST_PATH"/antlr4* "$DOC_DST_PATH"/ST-*
fi

exit 0

