package com.brayanalmengor04.postify.enums;

public enum Permission {
    CREATE_COMMENT,       // Crear comentario en un post
    LIKE_POST, // Dar "like"  un post
    EDIT_OWN_POST,
    DELETE_OWN_POST,     // Eliminar su propio post
    FULL_ADMIN,          // Administración completa
    DELETE_ANY_POST,     // Eliminar cualquier post
    EDIT_ANY_POST        // Modificar cualquier post
}
