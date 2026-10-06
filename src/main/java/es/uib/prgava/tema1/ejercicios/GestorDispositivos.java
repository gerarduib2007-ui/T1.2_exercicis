// GestorDispositivos.java
package es.uib.prgava.tema1.ejercicios;

/** Contrato completo, compuesto por los roles de lectura, escritura y exportación. */
public interface GestorDispositivos extends LectorDispositivos, EscritorDispositivos,
        ExportadorDispositivos, ExportadorJsonDispositivos { }
