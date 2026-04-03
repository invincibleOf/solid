# Principios SOLID en Java

Ejemplos prácticos de los 5 principios SOLID, cada uno con su versión **incorrecta** y **correcta**.

```
solid/
├── srp/
│   ├── SRPIncorrecto.java   → clase con múltiples responsabilidades
│   └── SRPCorrecto.java     → responsabilidades separadas por clase
├── ocp/
│   ├── OCPIncorrecto.java   → if/else que crece con cada nuevo tipo
│   └── OCPCorrecto.java     → estrategia via interfaz, nunca se modifica
├── lsp/
│   ├── LSPIncorrecto.java   → Cuadrado extends Rectángulo rompe el contrato
│   └── LSPCorrecto.java     → jerarquía plana con interfaz Forma
├── isp/
│   ├── ISPIncorrecto.java   → interfaz "gorda" con métodos no aplicables a todos
│   └── ISPCorrecto.java     → interfaces pequeñas y específicas por capacidad
└── dip/
    ├── DIPIncorrecto.java   → servicio acoplado a implementación concreta
    └── DIPCorrecto.java     → servicio depende de abstracción, inyección de dependencias
```

## Resumen rápido

| Principio | Pregunta clave |
|-----------|---------------|
| **SRP** | ¿Esta clase tiene más de una razón para cambiar? |
| **OCP** | ¿Agregar funcionalidad obliga a modificar código existente? |
| **LSP** | ¿La subclase puede reemplazar al padre sin romper nada? |
| **ISP** | ¿Alguna clase implementa métodos que no usa? |
| **DIP** | ¿El módulo de alto nivel depende de una implementación concreta? |
