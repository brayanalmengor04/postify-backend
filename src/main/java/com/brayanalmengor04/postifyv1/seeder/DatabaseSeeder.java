package com.brayanalmengor04.postifyv1.seeder;

import com.brayanalmengor04.postifyv1.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    @Autowired
    private RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("🔄 Inicializando Seeder...");

        roleService.addRoleIfNotExists("ADMIN", "Administrador con todos los permisos", "ALL_PERMISSION");
        roleService.addRoleIfNotExists("USER", "Usuario estándar con permisos básicos", "PERMISSION_LIMITED");
        roleService.addRoleIfNotExists("VISITOR", "VISITOR con permisos de visitante","VIEW_VISITOR");

        System.out.println("✅ Seeder completado.");
    }
}
