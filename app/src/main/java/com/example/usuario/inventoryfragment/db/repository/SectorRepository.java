package com.example.usuario.inventoryfragment.db.repository;

import com.example.usuario.inventoryfragment.pojo.Sector;

import java.util.ArrayList;

/**
 * @author Alfonso Chamorro Valle
 * Repositorio de sectores
 */

public class SectorRepository {

    /* Declaración */
    private ArrayList<Sector> sectors;
    private static SectorRepository sectorRepository;

    /* Inicialización */
    /* Inicializar todos los atributos de ámbito estático o de clase */
    static {
        sectorRepository = new SectorRepository();
    }

    public SectorRepository() {
        this.sectors = new ArrayList<>();
        initialize();
    }

    /**
     * El método ha de ser privado para garantizar que solo hay una instancia de Repository
     */
    private void initialize() {
        addSector(new Sector(1, "armario1", "arm1", "sirve para guardar cosas", 1, true, true));
        addSector(new Sector(1, "armario2", "arm2", "lleva directo a Narnia", 2, false, false));
        addSector(new Sector(1, "armario3", "arm3", "se compró en el Ikea", 3, true, true));
        addSector(new Sector(2, "armario4", "arm4", "su nombre es ar-Mario", 4, true, true));
        addSector(new Sector(2, "armario5", "arm5", "tiene cajones la cosa", 5, true, true));
        addSector(new Sector(2, "armario6", "arm6", "nadie ha salido de él", 6, true, true));
    }

    /* Métodos */
    public static SectorRepository getInstance() {
        return sectorRepository;
    }

    /**
     * Método que añade una dependencia
     * @param sector
     */
    public int addSector(Sector sector) {
        sectors.add(sector);
        return sector.get_ID();
    }

    public ArrayList<Sector> getSectors() {
        return sectors;
    }

}
