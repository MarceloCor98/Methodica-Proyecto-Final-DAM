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
    
    public partial class alumnos
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public alumnos()
        {
            this.respuestas = new HashSet<respuestas>();
            this.notas = new HashSet<notas>();
            this.cursos = new HashSet<cursos>();
        }
    
        public long id { get; set; }
        public string apellidos { get; set; }
        public string dni { get; set; }
        public Nullable<System.DateTime> fecha_nac { get; set; }
        public string nombre { get; set; }
        public string password { get; set; }
        public string username { get; set; }
    
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<respuestas> respuestas { get; set; }
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<notas> notas { get; set; }
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<cursos> cursos { get; set; }
    }
}
