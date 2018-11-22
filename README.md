# How to efficiently develop SAP Commerce

This repo showcases tips & tricks regarding efficient development with SAP
Commerce

## Prerequisites

[DCEVM for JDK 8](https://github.com/dcevm/dcevm) is installed as described [here](https://help.hybris.com/6.7.0/hcd/0b40907d5db14955bf4074b4b25e6998.html)

## Setup

1. clone the repository
1. download the latest SAP Commerce 6.7 version (`6.7.0.8` at the time of writing)
1. copy/move the platform.zip into the `lib/` folder, rename the file to `hybris-commerce-suite-6.7.0.8.zip`
1. `git checkout 1-minimal`
1. `./gradlew bootstrap`

Now you can follow the trail...
