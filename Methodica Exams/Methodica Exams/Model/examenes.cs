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
    
    public partial class examenes
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public examenes()
        {
            this.notas = new HashSet<notas>();
            this.preguntas = new HashSet<preguntas>();
        }
    
        public long id { get; set; }
        public bool activo { get; set; }
        public bool corregido { get; set; }
        public int duracion { get; set; }
        public Nullable<long> id_curso { get; set; }
        public Nullable<long> id_tema { get; set; }
    
        public virtual cursos cursos { get; set; }
        public virtual temas temas { get; set; }
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<notas> notas { get; set; }
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<preguntas> preguntas { get; set; }
    }
}
