//------------------------------------------------------------------------------
// <auto-generated>
//     Este código se generó a partir de una plantilla.
//
//     Los cambios manuales en este archivo pueden causar un comportamiento inesperado de la aplicación.
//     Los cambios manuales en este archivo se sobrescribirán si se regenera el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Methodica_Exams.Model
{
    using System;
    using System.Collections.Generic;
    
    public partial class respuestas
    {
        public long id { get; set; }
        public string texto { get; set; }
        public Nullable<long> id_alumno { get; set; }
        public Nullable<long> id_pregunta { get; set; }
    
        public virtual alumnos alumnos { get; set; }
        public virtual preguntas preguntas { get; set; }
    }
}
