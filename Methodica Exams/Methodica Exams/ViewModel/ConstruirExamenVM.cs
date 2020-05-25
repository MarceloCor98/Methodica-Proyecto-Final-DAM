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
        public ConstruirExamenVM(examenes examen)
        {
            Examen = examen;
            NuevaPregunta = new preguntas();
            NuevaPregunta.examenes = Examen;
        }

        public event PropertyChangedEventHandler PropertyChanged;

        public void AñadirPregunta()
        {
            BBDDService.AddPregunta(NuevaPregunta);
            NuevaPregunta = new preguntas();
            NuevaPregunta.examenes = Examen;
        }
    }
}
