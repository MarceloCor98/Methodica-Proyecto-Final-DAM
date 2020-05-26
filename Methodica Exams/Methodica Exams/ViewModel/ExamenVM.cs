using Methodica_Exams.Model;
using Methodica_Exams.Services;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Methodica_Exams.ViewModel
{
    public class ExamenVM : INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged;

        public examenes Examen { get; set; }

        public alumnos AlumnoLogueado { get; set; }

        public ObservableCollection<preguntas> Preguntas { get; set; }
        public ExamenVM(examenes examen,alumnos alumnoLogueado)
        {
            Examen = examen;
            AlumnoLogueado = alumnoLogueado;
        }


        public void GuardarRespuesta(string textoRespuesta,preguntas p)
        {
            respuestas r = new respuestas();
            r.alumnos = AlumnoLogueado;
            r.texto = textoRespuesta;
            r.preguntas = p;

            p.respuestas.Add(r);

            BBDDService.Guardar();
        }
    }
}
