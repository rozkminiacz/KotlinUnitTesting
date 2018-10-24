#!/usr/bin/env bash -x

toggle() {
    KOTLIN="$1"
    file="$2"

    if test "$KOTLIN" = "true" ; then
     file="${file/.groovy/}"
     mv -vf "${file}.groovy" "${file}"
     mv -vf "${file}.kts" "${file}.kotlin"

    else
      file="${file/.kotlin/}"
      mv -vf "${file}" "${file}.groovy"
      mv -vf "${file}.kotlin" "${file}.kts"
    fi

}



if test -f settings.gradle.kts ; then
    KOTLIN=true
    FILES=$( find . -name "build.gradle.groovy" )
    toggle "${KOTLIN}" settings.gradle.groovy
else
    KOTLIN=false
    FILES=$( find . -name "build.gradle.kotlin" )
    toggle "${KOTLIN}"  settings.gradle.kotlin
fi


for file in ${FILES} ; do
    toggle "${KOTLIN}" "$file"
done