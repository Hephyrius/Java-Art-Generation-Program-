/*
 * "$Id: image.h 1668 2011-12-23 06:23:11Z mike $"
 *
 *   Image management definitions for HTMLDOC, a HTML document processing
 *   program.
 *
 *   Copyright 2011 by Michael R Sweet.
 *   Copyright 1997-2010 by Easy Software Products.  All rights reserved.
 *
 *   This program is free software.  Distribution and use rights are outlined in
 *   the file "COPYING.txt".
 */

#ifndef _IMAGE_H_
#  define _IMAGE_H_

/*
 * Include necessary headers.
 */

#  include <stdio.h>
#  include <stdlib.h>
#  include "hdstring.h"

#  include "types.h"

#  ifdef __cplusplus
extern "C" {
#  endif /* __cplusplus */


/*
 * Image structure...
 */

typedef struct			/**** Image structure ****/
{
  char		filename[1024];	/* Name of image file (for caching of images */
  int		width,		/* Width of image in pixels */
		height,		/* Height of image in pixels */
		depth,		/* 1 for grayscale, 3 for RGB */
		use,		/* Number of times this image was used */
		obj;		/* Object number */
  uchar		*pixels;	/* 8-bit pixel data */
  uchar		*mask;		/* 1-bit mask data, if any */
  int		maskwidth,	/* Byte width of mask data */
		maskscale;	/* Scaling of mask data */
} image_t;


/*
 * Prototypes...
 */

extern void	image_copy(const char *src, const char *realsrc,
		           const char *destpath);
extern image_t	*image_find(const char *filename, int load_data = 0);
extern void	image_flush_cache(void);
extern int	image_getlist(image_t ***ptrs);
extern image_t	*image_load(const char *filename, int gray, int load_data = 0);
extern void	image_unload(image_t *img);

#  ifdef __cplusplus
}
#  endif /* __cplusplus */

#endif /* !_IMAGE_H_ */

/*
 * End of "$Id: image.h 1668 2011-12-23 06:23:11Z mike $".
 */
