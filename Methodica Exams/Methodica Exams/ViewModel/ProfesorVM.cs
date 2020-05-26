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

namespace Methodica_Exams.ViewModel
{
    public class ProfesorVM : INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged;
        public profesores ProfesorLogueado { get; set; }
        public ObservableCollection<cursos> CursosImpartidos { get; set; }

        public cursos CursoSeleccionado { get; set; }

        public ProfesorVM(usuarios usuarioLogueado)
        {
            if (usuarioLogueado.roles.Contains("ROLE_ADMIN"))
            {
                CursosImpartidos = BBDDService.getCursos();
                ProfesorLogueado = new profesores();
                ProfesorLogueado.nombre = usuarioLogueado.username;
            }
            else
            {
                ProfesorLogueado = BBDDService.getProfesorByUsername(usuarioLogueado.username);
                CursosImpartidos = BBDDService.getCursosByProfesor(ProfesorLogueado.id);
            }
            
        }

        public void AñadirExamen(long idTema)
        {
            examenes nuevoExamen = new examenes();
            nuevoExamen.temas = BBDDService.getTemaById(idTema);
            nuevoExamen.cursos = nuevoExamen.temas.cursos;
            BBDDService.AddExamen(nuevoExamen);

        }

        public void EliminarExamen(long idExamen)
        {
            BBDDService.DeleteExamenById(idExamen);
        }

        public void ConstruirExamen(long idExamen)
        {
            examenes examen = BBDDService.getExamenById(idExamen);
            ConstruirExamenDialogo construirExamenDialogo = new ConstruirExamenDialogo(examen);
            construirExamenDialogo.ShowDialog();
        }

        public void ActivarDesactivarExamen(long idExamen)
        {
            examenes examen = BBDDService.getExamenById(idExamen);
            examen.activo = !examen.activo;
            BBDDService.Guardar();
        }
    }
}
