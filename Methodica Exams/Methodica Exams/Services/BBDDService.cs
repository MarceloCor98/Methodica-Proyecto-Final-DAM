using Methodica_Exams.Model;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Methodica_Exams.Services
{
    public static class BBDDService
    {
        private static readonly methodicadbEntities contexto;
        static BBDDService()
        {
            contexto = new methodicadbEntities();
            contexto.usuarios.Load();
            contexto.cursos.Load();
            contexto.profesores.Load();
            contexto.examenes.Load();
            contexto.preguntas.Load();

        }

        public static void CargarBD()
        {
        }


        // USUARIOS
        public static ObservableCollection<usuarios> getUsuarios()
        {
            return contexto.usuarios.Local;
        }

        public static usuarios getUsuario(string username)
        {
            var usuario = (from u in contexto.usuarios
                           where u.username == username
                           select u).First();
            return usuario;
        }

        // PROFESORES
        public static profesores getProfesorByUsername(string username)
        {
            var profesor = (from p in contexto.profesores
                           where p.username == username
                           select p).First();
            return profesor;
        }

        // CURSOS
        public static cursos getCurso(string nombre)
        {
            var curso = (from c in contexto.cursos
                           where c.nombre == nombre
                         select c).First();
            return curso;
        }

        public static ObservableCollection<cursos> getCursosByProfesor(long idProfesor)
        {
            var curso = (from c in contexto.cursos
                         where c.id_profesor == idProfesor 
                         select c);
            return new ObservableCollection<cursos>(curso);
        }

        // EXAMENES

        public static void AddExamen(examenes examen)
        {
            contexto.examenes.Add(examen);
            contexto.SaveChanges();
        }

        public static void DeleteExamen(examenes examen)
        {
            var preguntas = (from p in contexto.preguntas
                         where p.id_examen == examen.id
                         select p);

            contexto.preguntas.RemoveRange(preguntas);
            contexto.examenes.Remove(examen);
            contexto.SaveChanges();
        }

        public static void DeleteExamenById(long idExamen)
        {
            var preguntas = (from p in contexto.preguntas
                             where p.id_examen == idExamen
                             select p);

            contexto.preguntas.RemoveRange(preguntas);

            contexto.examenes.Remove(getExamenById(idExamen));
            contexto.SaveChanges();
        }

        public static examenes getExamenById(long id)
        {
            var examen = (from e in contexto.examenes
                         where e.id == id
                         select e).First();
            return examen;
        }

        // TEMAS 

        public static temas getTemaById(long id)
        {
            var tema = (from t in contexto.temas
                          where t.id == id
                          select t).First();
            return tema;
        }

        // PREGUNTAS

        public static void AddPregunta(preguntas pregunta)
        {
            contexto.preguntas.Add(pregunta);
            contexto.SaveChanges();
        }

        public static void DeletePregunta(preguntas pregunta)
        {
            contexto.preguntas.Remove(pregunta);
            contexto.SaveChanges();
        }
    }
}
