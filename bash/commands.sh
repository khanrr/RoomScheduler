#!/bin/sh
cat SecurityLog-rev2.xml > NewLog.xml
grep "<EventID>4624" SecurityLog-rev2.xml > Event4624.xml
grep -c "<EventID>4625" SecurityLog-rev2.xml > Event4625.xml
