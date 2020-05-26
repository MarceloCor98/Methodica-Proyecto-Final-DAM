using Methodica_Exams.Model;
using Methodica_Exams.Services;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Methodica_Exams.ViewModel
{
    public class ConstruirExamenVM : INotifyPropertyChanged
    {
        public examenes Examen { get; set; }
        public preguntas NuevaPregunta { get; set; }
        public preguntas PreguntaSeleccionada { get; set; }

        public float NotaTotal { get; set; }
        public ConstruirExamenVM(examenes examen)
        {
            Examen = examen;
            NuevaPregunta = new preguntas();
            NuevaPregunta.examenes = Examen;
            foreach (preguntas p in Examen.preguntas)
                NotaTotal += p.puntuacion;
        }

        public event PropertyChangedEventHandler PropertyChanged;

        public void AñadirPregunta()
        {
            NotaTotal += NuevaPregunta.puntuacion;
            BBDDService.AddPregunta(NuevaPregunta);
            NuevaPregunta = new preguntas();
            NuevaPregunta.examenes = Examen;
        }

        public void EliminarPregunta()
        {
            NotaTotal -= PreguntaSeleccionada.puntuacion;
            BBDDService.DeletePregunta(PreguntaSeleccionada);
        }
    }
}
