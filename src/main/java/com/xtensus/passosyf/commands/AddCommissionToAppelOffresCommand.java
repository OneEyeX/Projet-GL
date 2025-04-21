package com.xtensus.passosyf.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xtensus.passosyf.entities.AppelOffres;
import com.xtensus.passosyf.entities.Commission;
import com.xtensus.passosyf.exceptions.ResourceNotFoundException;
import com.xtensus.passosyf.services.AppelOffresService;
import com.xtensus.passosyf.services.CommissionService;

public class AddCommissionToAppelOffresCommand implements Command {

    private final int commissionId;
    private final int appelOffreId;
    private final AppelOffresService appelOffresService;
    private final CommissionService commissionService;
    private static final Logger log = LoggerFactory.getLogger(AddCommissionToAppelOffresCommand.class);

    public AddCommissionToAppelOffresCommand(int commissionId, int appelOffreId,
            AppelOffresService appelOffresService,
            CommissionService commissionService) {
        this.commissionId = commissionId;
        this.appelOffreId = appelOffreId;
        this.appelOffresService = appelOffresService;
        this.commissionService = commissionService;
    }

    @Override
    public void execute() {
        log.info("⚙️ Executing... (from AddCommissionToAppelOffresCommand)");
        AppelOffres appelOffres = appelOffresService.getAppelOffresById(appelOffreId);
        if (appelOffres == null)
            throw new ResourceNotFoundException("Appel d'offres non trouvé");

        Commission commission = commissionService.getCommissionById(commissionId);
        if (commission == null)
            throw new ResourceNotFoundException("Commission non trouvée");

        appelOffres.getCommissions().add(commission);
        commission.getAppelOffres().add(appelOffres);
        appelOffresService.saveAppelOffres(appelOffres);
    }
}