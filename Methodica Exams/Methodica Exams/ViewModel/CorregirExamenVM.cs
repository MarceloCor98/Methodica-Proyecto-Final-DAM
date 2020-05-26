using Methodica_Exams.Model;
using Methodica_Exams.Services;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;

namespace Methodica_Exams.ViewModel
{
    public class CorregirExamenVM : INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged;
        public examenes Examen { get; set; }
        public alumnos Alumno { get; set; }
        public float NotaFinal { get; set; }
        public float NotaMaxima { get; set; }

        public notas Nota { get; set; }
        public ObservableCollection<respuestas> Respuestas { get; set; }

        public CorregirExamenVM(examenes examen, alumnos alumno)
        {
            Examen = examen;
            Alumno = alumno;
            Respuestas = BBDDService.getRespuestasByExamenAndAlumno(examen.id, alumno.id);
            NotaMaxima = examen.preguntas.Sum(x => x.puntuacion);

            Nota = BBDDService.GetNotaByExamenAlumno(examen, alumno);

            if (Nota == null)
            {
                Nota = new notas();
                Nota.alumnos= Alumno;
                Nota.examenes = Examen;
                Nota.nota = Respuestas.Sum(x => x.puntuacion);
            }
               

        }
                

        public float PuntuacionDePregunta(long idPregunta)
        {
            return BBDDService.getPreguntaById(idPregunta).puntuacion;
        }

        public void CalcularNota()
        {
            BBDDService.Guardar();
            Nota.nota = Respuestas.Sum(x => x.puntuacion);
            
        }

        public void Corregir()
        {
            if(Nota.id == 0 && Nota.nota > 0)
            {
                BBDDService.AddNota(Nota);
            }
                
            BBDDService.Guardar();
        }
    }
}
