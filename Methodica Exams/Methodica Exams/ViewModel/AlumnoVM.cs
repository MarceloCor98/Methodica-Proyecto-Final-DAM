using Methodica_Exams.Model;
using Methodica_Exams.Services;
using Methodica_Exams.View;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace Methodica_Exams.ViewModel
{
    public class AlumnoVM : INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged;
        public alumnos AlumnoLogueado { get; set; }
        public ObservableCollection<cursos> CursosMatriculados { get; set; }
        public cursos CursoSeleccionado { get; set; }

        public ObservableCollection<notas> Notas{ get; set; }

        public ObservableCollection<examenes> ExamenesActivos { get; set; }

        public AlumnoVM(usuarios usuarioLogueado)
        {
            if (usuarioLogueado.roles.Contains("ROLE_ADMIN"))
            {
                CursosMatriculados = BBDDService.getCursos();
                AlumnoLogueado = new alumnos();
                AlumnoLogueado.nombre = usuarioLogueado.username;
                cursos c = new cursos();
            }
            else
            {
                AlumnoLogueado = BBDDService.getAlumnoByUsername(usuarioLogueado.username);
                CursosMatriculados = new ObservableCollection<cursos>(AlumnoLogueado.cursos);
                
            }
        }


        public void CargarNotas()
        {
            Notas = BBDDService.getNotasByCurso(CursoSeleccionado.id);
        }

        public void CargarExamenes()
        {
            ExamenesActivos = BBDDService.getExamenesActivos(CursoSeleccionado.id);
        }

        public void RealizarExamen(long idExamen)
        {
            if(BBDDService.isExamenYaRealizadoPorAlumno(AlumnoLogueado,idExamen))
                MessageBox.Show("Ya ha realizado este examen", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
            else
            {
                examenes examen = BBDDService.getExamenById(idExamen);
                Examen examenVentana = new Examen(examen, AlumnoLogueado);
                examenVentana.ShowDialog();
            }
            
        }
    }
}
