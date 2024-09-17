package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class VetControllerTest {

    VetController vetController;
    VetService vetService;
    SpecialtyService specialtyService;

    @BeforeEach
    void setUp() {
        specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);
        vetController = new VetController(vetService);

        Vet v1 = new Vet(1L, "vimal", "Nayak",null);
        Vet v2 = new Vet(2L, "Apexa", "Nayak",null);
        vetService.save(v1);
        vetService.save(v2);
    }
    @Test
    void listVets() {
        Model model = new ModelMapImpl();
        String view = vetController.listVets(model);
        assertThat("vets/index").isEqualTo(view);

        Set modelAttribute = (Set) ((ModelMapImpl) model).getMap().get("vets");

        assertThat(modelAttribute.size()).isEqualTo(2);
    }
}