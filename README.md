Nexus APT Plugin
================

this plugin generates a Packages.gz for each nexus repository and allows the repository to be 
listed in a debian /etc/apt/sources.list file so that it can be used by aptitude/apt-get/ubuntu 
software center.

Installation
============

- Checkout the source code
- Run a maven build by going itno your ${project.home} directory and executing 'mvn clean install'
- Go to your target directory
- Unzip nexus-apt-plugin-${version}-bundle.zip into your 'sonatype-work/nexus/plugin-repository/' folder
- Restart nexus

> to be sure that the index is regenerated (the plugin adds attributes to index) it could be 
neccessary to delete the index files under sonatype-work/nexus/indexer

All repositories now contain a Packages.gz that lists all debian packages the indexer was able 
to find.

Pitfall
-------

The indexer cannot find packages when there is a main artifact with the same name:
If the artifacts are named like:

-  nexus-apt-plugin-${version}.jar 
-  nexus-apt-plugin-${version}.deb 

The indexer won't index the debian package. In order to make the indexer index the debian 
package it needs a classifier:

-  nexus-apt-plugin-${version}.jar 
-  nexus-apt-plugin-${version}-all.deb 
  
This is fine.

Adding a repository to sources.list
===================================

- echo 'deb http://repository.yourcompany.com/content/repositories/releases/Packages.gz ./' >> /etc/apt/sources.list.d/yourcompany.list 
- apt-get update
- apt-get install ${package.name}
