/*
 * "$Id: config.h 1720 2014-03-11 02:40:21Z msweet $"
 *
 *   Configuration file for HTMLDOC.
 *
 *   Copyright 2011 by Michael R Sweet.
 *   Copyright 1997-2010 by Easy Software Products.  All rights reserved.
 *
 *   This program is free software.  Distribution and use rights are outlined in
 *   the file "COPYING.txt".
 */

/*
 * What is the version number for this software?
 */

#define SVERSION	"1.8.29"


/*
 * Limits for the output "engines"...
 */

#define MAX_CHAPTERS	1000	/* Maximum number of chapters or files */
#define MAX_COLUMNS	200	/* Maximum number of columns in a table */
#define MAX_HF_IMAGES	10	/* Maximum number of header/footer images */


/*
 * Memory allocation units for other stuff...
 */

#define ALLOC_FILES	10	/* Temporary/image files */
#define ALLOC_HEADINGS	50	/* Headings */
#define ALLOC_LINKS	100	/* Web links */
#define ALLOC_OBJECTS	100	/* PDF objects */
#define ALLOC_PAGES	10	/* PS/PDF pages */
#define ALLOC_ROWS	20	/* Table rows */


/*
 * Locations of files (overridden by the registry...)
 */

#define DOCUMENTATION	"C:/Program Files/HTMLDOC/doc"
#define HTML_DATA	"C:/Program Files/HTMLDOC"


/*
 * Do we have the FLTK library?
 */

#ifndef _CONSOLE
#  define HAVE_LIBFLTK
#endif /* !_CONSOLE */


/*
 * Do we have the Xpm library?
 */

#undef HAVE_LIBXPM


/*
 * Which encryption libraries do we have?
 */

#undef HAVE_CDSASSL
#undef HAVE_GNUTLS
#undef HAVE_LIBSSL
#define HAVE_SSPISSL
#define HAVE_SSL


/*
 * Do we need to use <strings.h>?
 */

#undef HAVE_STRINGS_H


/*
 * Do we have the <locale.h> header file?
 */

#define HAVE_LOCALE_H


/*
 * Do we have some of the "standard" string functions?
 */

#define HAVE_STRDUP
#define HAVE_STRCASECMP
#define HAVE_STRNCASECMP


/*
 * How about snprintf() and vsnprintf()?
 */

#define HAVE_SNPRINTF
#define HAVE_VSNPRINTF


/*
 * Does the "tm" structure contain the "tm_gmtoff" member?
 */

#undef HAVE_TM_GMTOFF


/*
 * Do we have hstrerror()?
 */

#undef HAVE_HSTRERROR


/*
 * Do we have getaddrinfo()?
 */

#define HAVE_GETADDRINFO


/*
 * Do we have getnameinfo()?
 */

#define HAVE_GETNAMEINFO


/*
 * Do we have the long long type?
 */

#undef HAVE_LONG_LONG

#ifdef HAVE_LONG_LONG
#  define HTMLDOC_LLFMT		"%lld"
#  define HTMLDOC_LLCAST	(long long)
#else
#  define HTMLDOC_LLFMT		"%ld"
#  define HTMLDOC_LLCAST	(long)
#endif /* HAVE_LONG_LONG */


/*
 * Do we have the strtoll() function?
 */

#undef HAVE_STRTOLL

#ifndef HAVE_STRTOLL
#  define strtoll(nptr,endptr,base) strtol((nptr), (endptr), (base))
#endif /* !HAVE_STRTOLL */


/*
 * End of "$Id: config.h 1720 2014-03-11 02:40:21Z msweet $".
 */
