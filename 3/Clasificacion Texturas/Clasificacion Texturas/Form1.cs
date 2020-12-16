using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Collections.Generic;

namespace Clasificacion_Texturas
{
    public partial class Form1 : Form
    {
        int cR, cB, cG;
        int cmR, cmB, cmG;

        Dictionary<String, int[]> textures = new Dictionary<String, int[]>();
        Dictionary<String, Color> colors = new Dictionary<String, Color>();

        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Bitmap bmp = new Bitmap(pictureBox1.Image);
            Bitmap bmp2 = new Bitmap(bmp.Width, bmp.Height);

            int ciR, ciG, ciB;
            Color c = new Color();
            int interv = 25;
            for (int i = 0; i < bmp.Width - 5; i++)
            {
                for (int j = 0; j < bmp.Height - 5; j++)
                {
                    ciR = 0;
                    ciG = 0;
                    ciB = 0;

                    c = bmp.GetPixel(i, j);
                    
                    for (int x = i; x < i + 5; x++)
                        for (int y = j; y < j + 5; y++)
                        {
                            c = bmp.GetPixel(i, j);
                            ciR += c.R;
                            ciG += c.G;
                            ciB += c.B;
                        }
                    ciR /= 25;
                    ciG /= 25;
                    ciB /= 25;
                    int[] cls = { ciR,ciG, ciB };

                    foreach (String k in textures.Keys) 
                    {
                        bool b = true;
                        int[] clText = textures[k];
                        for (int l = 0; l < clText.Length; l++) {
                            if (!(clText[l] - interv < cls[l] && cls[l] < clText[l] + interv))
                            {
                                b = false;
                                break;
                            }

                        }
                        if (b) {
                            
                            for (int x = i; x < i + 5; x++)
                                for (int y = j; y < j + 5; y++)
                                {
                                    bmp2.SetPixel(x, y, colors[k]);
                                }
                            break;
                        }
                        else
                        {
                            for (int x = i; x < i + 5; x++)
                                for (int y = j; y < j + 5; y++)
                                {
                                    bmp2.SetPixel(x, y, Color.FromArgb(c.R, c.G, c.B));
                                }
                        }
                    }

                }
            }
            pictureBox1.Image = bmp2;

        }

        private void pictureBox1_DragDrop(object sender, DragEventArgs e)
        {
            var data = e.Data.GetData(DataFormats.FileDrop);
            if (data != null) {
                var fileName = data as String[];

                if (fileName.Length > 0) {
                    Bitmap bmp = new Bitmap(fileName[0]);
                    pictureBox1.Image = bmp;
                }
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            //Bitmap img = new Bitmap(pictureBox1.Image);

            Random rnd = new Random();
           


            String nmText = textBox4.Text.ToLower();
            if (nmText != null || nmText != "") {
                int[] cl = { cmR, cmG, cmB };
               
                if (textures.ContainsKey(nmText))
                {
                    int[] oldCl = textures[nmText];
                    for (int i = 0; i < oldCl.Length; i++)
                        cl[i] = (cl[i] + oldCl[i]) / 2;

                }
                else {
                    textures.Add(nmText, cl);
                    int r = rnd.Next(256), g = rnd.Next(256), b = rnd.Next(256);
                    colors.Add(nmText, Color.FromArgb(r,g,b));
                }
                    
            }

            textBox4.Text = "";


        }

        private void Form1_Load(object sender, EventArgs e)
        {

            colors.Add("tierra", Color.FromArgb( 133, 42, 0 ));
            colors.Add("lago", Color.FromArgb(0, 0, 255));
            colors.Add("nieve", Color.FromArgb(151, 183, 191));

           textures.Add("tierra", new int[] { 176, 150, 136 });
           textures.Add("lago", new int[] { 44, 43, 122 });
           textures.Add("nieve", new int[] { 255, 255, 254 });


            pictureBox1.AllowDrop = true;


       

        }
    

        private void pictureBox1_DragEnter(object sender, DragEventArgs e)
        {
            e.Effect = DragDropEffects.Copy;
        }


        private void pictureBox1_MouseClick(object sender, MouseEventArgs e)
        {
            Bitmap bmp = new Bitmap(pictureBox1.Image);
            Color c = new Color();
            c = bmp.GetPixel(e.X, e.Y);
            textBox1.Text = c.R.ToString();
            textBox2.Text = c.G.ToString();
            textBox3.Text = c.B.ToString();

            cR = c.R;
            cG = c.G;
            cB = c.B;
            cmR = cmB = cmG = 0;

            for (int i = e.X; i < e.X + 5; i++)
                for (int j = e.Y; j < e.Y + 5; j++)
                {
                    c = bmp.GetPixel(i, j);
                    cmR += c.R;
                    cmG += c.G;
                    cmB += c.B;
                }
            cmR /= 25;
            cmG /= 25;
            cmB /= 25;
            textBox1.Text = cmR.ToString();
            textBox2.Text = cmG.ToString();
            textBox3.Text = cmB.ToString();
        }
    }
}
