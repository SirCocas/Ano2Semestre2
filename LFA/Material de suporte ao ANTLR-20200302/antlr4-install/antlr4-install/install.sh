#!/bin/bash
#
# Miguel Oliveira e Silva (mos@ua.pt), 2020

if (( $# == 0 )); then
   FILES_PATH="."
elif (( $# == 1 )); then
   FILES_PATH="$1"
else
   echo "Usage: ./install.sh [path-to-files]!"
   exit 10
fi

if ! [ -d "$FILES_PATH" ]; then
   echo "ERROR: directory $FILES_PATH does not exists!"
   exit 10
fi

TMP_DIR="TMP_DIR"
JAR_DST_PATH=/usr/local/lib
BIN_DST_PATH=/usr/local/bin
DOC_DST_PATH=/usr/local/doc/javadoc


echo "ANTLR4 installation script (Miguel Oliveira e Silva, mos@ua.pt, 2020)."
echo ""
echo "This script requires sudo execution permission."
echo "It will change the following directories and files:"
echo "- directory $JAR_DST_PATH"
echo "- directory $BIN_DST_PATH"
echo "- directory $DOC_DST_PATH"
echo "- file ~/.bashrc"
echo ""
echo "If some of these condition are not possible or desired, please abort this installation script."
echo "Manual installation instructions can be found in file INSTALL.txt."
echo ""
read -p "Proceed with installation (y/N)? " ans
if [[ $ans != "y" && $ans != "Y" ]]; then
   echo "Installation aborted"
   exit 10
fi

echo "Phase #1: checking files"
read -p "<press RETURN to continue> " ans
N=$(find "$FILES_PATH" -maxdepth 1 -name antlr-4.*-complete.jar | wc -l)
if (( N == 0 )); then
   echo "ERROR: antlr4 complete jar file not found in path $FILES_PATH!"
   exit 1
elif (( N > 1 )); then
   echo "ERROR: found more than one antlr4 complete jar files in path $FILES_PATH!"
   exit 1
fi
ANTLR4Path=$(find "$FILES_PATH" -maxdepth 1 -name antlr-4.*-complete.jar)
ANTLR4File=$(basename $ANTLR4Path)
ANTLR4Version=$(echo $ANTLR4File | sed 's/^antlr-\(.*\)-complete.jar/\1/g')
echo "- found antlr4 version $ANTLR4Version, in file $ANTLR4Path"

ANTLR4RunTimePath="$FILES_PATH/antlr-runtime-$ANTLR4Version.jar"
if ! [ -f "$ANTLR4RunTimePath" ]; then
   echo "WARNING: antlr4 runtime file not found in path $FILES_PATH!"
   ANTLR4RunTimePath=""
else
   echo "- found antlr4 runtime version $ANTLR4Version in file $ANTLR4RunTimePath"
fi

ANTLR4DocFile="$FILES_PATH/antlr4-$ANTLR4Version-javadoc.zip"
if ! [ -f "$ANTLR4DocFile" ]; then
   echo "WARNING: antlr4 documentation zip file not found in path $FILES_PATH!"
   ANTLR4DocFile=""
else
   echo "- found antlr4 version $ANTLR4Version documentation in file $ANTLR4DocFile"
fi

N=$(find "$FILES_PATH" -maxdepth 1 -name ST-*.jar | wc -l)
if (( N == 0 )); then
   echo "ERROR: StringTemplate jar file not found in path $FILES_PATH!"
   exit 1
elif (( N > 1 )); then
   echo "ERROR: found more than one StringTemplate files in path $FILES_PATH!"
   exit 1
fi
STPath=$(find "$FILES_PATH" -maxdepth 1 -name ST-*.jar)
STFile=$(basename $STPath)
STVersion=$(echo $STFile | sed 's/^ST-\(.*\).jar/\1/g')
echo "- found StringTemplate version $STVersion, in file: $STPath"
STDocFile="$FILES_PATH/ST-$STVersion-javadoc.zip"
if ! [ -f "$STDocFile" ]; then
   echo "WARNING: StringTemplate documentation zip file not found in path $FILES_PATH!"
   STDocFile=""
else
   echo "- found StringTemplate version $STVersion documentation in file $STDocFile"
fi

N=$(find "$FILES_PATH" -maxdepth 1 -name antlr4-bin*.zip | wc -l)
if (( N == 0 )); then
   echo "ERROR: antlr4 scripts zip file not found in path $FILES_PATH!"
   exit 1
elif (( N > 1 )); then
   echo "ERROR: found more than one antlr4 scripts zip files in path $FILES_PATH!"
   exit 1
fi
ScriptsFile=$(find "$FILES_PATH" -maxdepth 1 -name antlr4-bin*.zip)
ScriptsVersion=$(basename $ScriptsFile | sed 's/^antlr4-bin-v\(.*\).zip/\1/g')
echo "- found antlr4 scripts zip file version $ScriptsVersion, in file: $ScriptsFile"

if [ -d "$TMP_DIR" ]; then
   echo "ERROR: temporary directory $TMP_DIR already exists (remove it, and rerun installation script)!"
   exit 1
fi

if ! ( command -v gawk >& /dev/null ); then
   echo "ERROR: gawk not found!"
   read -p "Install gakw (Y/n)? " ans
   if [[ $ans != "n" && $ans != "N" ]]; then
      sudo apt install gawk
   else
      echo "  run command:"
      echo "    sudo apt install gawk"
      exit 2
   fi
fi
echo "Phase #1 done."


echo ""
echo "Phase #2: checking java versions"
read -p "<press RETURN to continue> " ans
if ! ( command -v java >& /dev/null ); then
   echo "ERROR: java virtual machine not found!"
   exit 2
fi
JAVA_VERSION=$(java -version |& head -1 | sed 's/[^0-9._]\+//g' | sed 's/\.[0-9_]\+$//g')
echo "- java version: $JAVA_VERSION"

if ! ( command -v javac >& /dev/null ); then
   echo "ERROR: java compiler not found!"
   exit 2
fi
JAVAC_VERSION=$(javac -version |& head -1 | sed 's/[^0-9._]\+//g' | sed 's/\.[0-9_]\+$//g')
echo "- javac version: $JAVAC_VERSION"

if [[ $JAVA_VERSION != $JAVAC_VERSION ]]; then
   echo "ERROR: java and javac have different versions!"
   exit 2
fi
echo "Phase #2 done."


echo ""
echo "Phase #3: installing jar files and update bashrc (sudo required, and bash shell usage assumed)"
read -p "Execute phase #3 (Y/n)? " ans
if [[ $ans != "n" && $ans != "N" ]]; then
   echo "- installing jar files:"
   sudo cp -v "$ANTLR4Path" "$ANTLR4RunTimePath" "$STPath" "$JAR_DST_PATH" || (echo "ERROR: copying jar files!"; exit 3)
   echo "- updating CLASSPATH and add ANTLR4_PATH to ~/.bashrc file:"
   echo "export CLASSPATH=\".:"$JAR_DST_PATH"/${ANTLR4File}:"$JAR_DST_PATH"/${STFile}:$CLASSPATH\"" >> ~/.bashrc || (echo "ERROR: changing ~/.bashrc file!"; exit 3)
   echo "export ANTLR4_PATH=\""$JAR_DST_PATH"\"" >> ~/.bashrc || (echo "ERROR: changing ~/.bashrc file!"; exit 3)
   echo "Phase #3 done."
fi


echo ""
echo "Phase #4: installing script files (sudo required)"
read -p "Execute phase #4 (Y/n)? " ans
if [[ $ans != "n" && $ans != "N" ]]; then
   mkdir -v "$TMP_DIR"
   unzip "$ScriptsFile" -d "$TMP_DIR"
   sudo mv -vf "$TMP_DIR"/bin/* "$BIN_DST_PATH"/
   rm -vrf "$TMP_DIR"
   echo "Phase #4 done."
fi

echo ""
echo "Phase #5: installing ANTLR4 and Java documentation"
read -p "Execute phase #5 (Y/n)? " ans
if [[ $ans != "n" && $ans != "N" ]]; then
   if [[ $ANTLR4DocFile != "" ]]; then
      echo "- install antlr4 library documentation in path $DOC_DST_PATH"
      if ! [ -d "$DOC_DST_PATH" ]; then
         sudo mkdir -v --parents "$DOC_DST_PATH"
      fi
      echo "sudo unzip ${ANTLR4DocFile} -d $DOC_DST_PATH"
      sudo unzip "${ANTLR4DocFile}" -d "$DOC_DST_PATH" > /dev/null || (echo "ERROR: installing antlr4 documentation files!"; exit 5)
   fi
   if [[ $STDocFile != "" ]]; then
      echo "- install StringTemplate library documentation in path $DOC_DST_PATH"
      if ! [ -d "$DOC_DST_PATH" ]; then
         sudo mkdir -v --parents "$DOC_DST_PATH"
      fi
      echo "sudo unzip ${STDocFile} -d $DOC_DST_PATH"
      sudo unzip "${STDocFile}" -d "$DOC_DST_PATH" > /dev/null || (echo "ERROR: installing StringTemplate documentation files!"; exit 5)
   fi
   JAVADOC_VERSION=$(echo $JAVAC_VERSION | sed 's/^1\.//g' | sed 's/\..*$//g')
   read -p "Install java standard library documentation  (Y/n)? " ans
   if [[ $ans != "n" && $ans != "N" ]]; then
      sudo apt install openjdk-${JAVADOC_VERSION}-doc
   else
      echo "- to install java standard library documentation run command:"
      echo "    sudo apt install openjdk-${JAVADOC_VERSION}-doc"
   fi
   echo "Phase #5 done."
fi

echo ""
echo "Start a new terminal before start ANTLR4ring! (necessary to ensure that the new ./bashrc is executed)"

exit 0

